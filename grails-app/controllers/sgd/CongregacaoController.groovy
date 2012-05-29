package sgd

import org.springframework.dao.DataIntegrityViolationException
import grails.converters.JSON

class CongregacaoController extends BaseController {
//class CongregacaoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [congregacaoInstanceList: Congregacao.list(params), congregacaoInstanceTotal: Congregacao.count()]
    }

    def listJSON = {
        def sortIndex = params.sidx ?: 'name'
		def sortOrder  = params.sord ?: 'asc'
		def maxRows = Integer.valueOf(params.rows)
		def currentPage = Integer.valueOf(params.page) ?: 1
		def rowOffset = currentPage == 1 ? 0 : (currentPage - 1) * maxRows
		def congregacoes = Congregacao.createCriteria().list(max: maxRows, offset: rowOffset) {
			if (params.congregacao)
				ilike('congregacao', "%${params.congregacao}%")

			if (params.tipo)
				ilike('tipo', "%${params.tipo}%")

			order(sortIndex, sortOrder)
		}

		def totalRows = congregacoes.size()
		def numberOfPages = Math.ceil(totalRows / maxRows)

		def results = congregacoes?.collect {
			[
				 cell: [it.congregacao, it.tipo],
				 id: it.id
			]
		}

		def jsonData = [rows: results, page: currentPage, records: totalRows, total: numberOfPages]
                render jsonData as JSON
    }


    def create() {
        [congregacaoInstance: new Congregacao(params)]
    }

    def save() {
        def congregacaoInstance = new Congregacao(params)
        if (!congregacaoInstance.save(flush: true)) {
            render(view: "create", model: [congregacaoInstance: congregacaoInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'congregacao.label', default: 'Congregacao'), congregacaoInstance.id])
        redirect(action: "show", id: congregacaoInstance.id)
    }

    def show() {
        def congregacaoInstance = Congregacao.get(params.id)
        if (!congregacaoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'congregacao.label', default: 'Congregacao'), params.id])
            redirect(action: "list")
            return
        }

        [congregacaoInstance: congregacaoInstance]
    }

    def edit() {
        def congregacaoInstance = Congregacao.get(params.id)
        if (!congregacaoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'congregacao.label', default: 'Congregacao'), params.id])
            redirect(action: "list")
            return
        }

        [congregacaoInstance: congregacaoInstance]
    }

    def update() {
        def congregacaoInstance = Congregacao.get(params.id)
        if (!congregacaoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'congregacao.label', default: 'Congregacao'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (congregacaoInstance.version > version) {
                congregacaoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'congregacao.label', default: 'Congregacao')] as Object[],
                        "Another user has updated this Congregacao while you were editing")
                render(view: "edit", model: [congregacaoInstance: congregacaoInstance])
                return
            }
        }

        congregacaoInstance.properties = params

        if (!congregacaoInstance.save(flush: true)) {
            render(view: "edit", model: [congregacaoInstance: congregacaoInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'congregacao.label', default: 'Congregacao'), congregacaoInstance.id])
        redirect(action: "show", id: congregacaoInstance.id)
    }

    def delete() {
        def congregacaoInstance = Congregacao.get(params.id)
        if (!congregacaoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'congregacao.label', default: 'Congregacao'), params.id])
            redirect(action: "list")
            return
        }

        try {
            congregacaoInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'congregacao.label', default: 'Congregacao'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'congregacao.label', default: 'Congregacao'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
