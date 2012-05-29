package sgd

import org.springframework.dao.DataIntegrityViolationException

class CampanhaCongregacaoController extends BaseController{
//class CampanhaCongregacaoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [campanhaCongregacaoInstanceList: CampanhaCongregacao.list(params), campanhaCongregacaoInstanceTotal: CampanhaCongregacao.count()]
    }

    def create() {
        [campanhaCongregacaoInstance: new CampanhaCongregacao(params)]
    }

    def save() {
        def campanhaCongregacaoInstance = new CampanhaCongregacao(params)
        if (!campanhaCongregacaoInstance.save(flush: true)) {
            render(view: "create", model: [campanhaCongregacaoInstance: campanhaCongregacaoInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'campanhaCongregacao.label', default: 'CampanhaCongregacao'), campanhaCongregacaoInstance.id])
        redirect(action: "show", id: campanhaCongregacaoInstance.id)
    }

    def show() {
        def campanhaCongregacaoInstance = CampanhaCongregacao.get(params.id)
        if (!campanhaCongregacaoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'campanhaCongregacao.label', default: 'CampanhaCongregacao'), params.id])
            redirect(action: "list")
            return
        }

        [campanhaCongregacaoInstance: campanhaCongregacaoInstance]
    }

    def edit() {
        def campanhaCongregacaoInstance = CampanhaCongregacao.get(params.id)
        if (!campanhaCongregacaoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'campanhaCongregacao.label', default: 'CampanhaCongregacao'), params.id])
            redirect(action: "list")
            return
        }

        [campanhaCongregacaoInstance: campanhaCongregacaoInstance]
    }

    def update() {
        def campanhaCongregacaoInstance = CampanhaCongregacao.get(params.id)
        if (!campanhaCongregacaoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'campanhaCongregacao.label', default: 'CampanhaCongregacao'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (campanhaCongregacaoInstance.version > version) {
                campanhaCongregacaoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'campanhaCongregacao.label', default: 'CampanhaCongregacao')] as Object[],
                        "Another user has updated this CampanhaCongregacao while you were editing")
                render(view: "edit", model: [campanhaCongregacaoInstance: campanhaCongregacaoInstance])
                return
            }
        }

        campanhaCongregacaoInstance.properties = params

        if (!campanhaCongregacaoInstance.save(flush: true)) {
            render(view: "edit", model: [campanhaCongregacaoInstance: campanhaCongregacaoInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'campanhaCongregacao.label', default: 'CampanhaCongregacao'), campanhaCongregacaoInstance.id])
        redirect(action: "show", id: campanhaCongregacaoInstance.id)
    }

    def delete() {
        def campanhaCongregacaoInstance = CampanhaCongregacao.get(params.id)
        if (!campanhaCongregacaoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'campanhaCongregacao.label', default: 'CampanhaCongregacao'), params.id])
            redirect(action: "list")
            return
        }

        try {
            campanhaCongregacaoInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'campanhaCongregacao.label', default: 'CampanhaCongregacao'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'campanhaCongregacao.label', default: 'CampanhaCongregacao'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
