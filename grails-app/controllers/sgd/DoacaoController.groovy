package sgd

import org.springframework.dao.DataIntegrityViolationException

class DoacaoController extends BaseController {
//class DoacaoController {

    def campanhaService

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [doacaoInstanceList: Doacao.list(params), doacaoInstanceTotal: Doacao.count()]
    }

    def create() {
        [doacaoInstance: new Doacao(params)]
    }

    def save() {
        def doacaoInstance = new Doacao(params)
        doacaoInstance.usuario = session.usuario
        doacaoInstance.dataLancamento = new Date()

        if (!doacaoInstance.save(flush: true)) {

            render(view: "create", model: [doacaoInstance: doacaoInstance])
            return
        }
        campanhaService.setSaldo(doacaoInstance)

        flash.message = message(code: 'default.created.message', args: [message(code: 'doacao.label', default: 'Doacao'), doacaoInstance.id])
        //redirect(action: "show", id: doacaoInstance.id)
        redirect(action: "list", params: params)
    }

    def show() {
        def doacaoInstance = Doacao.get(params.id)
        if (!doacaoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'doacao.label', default: 'Doacao'), params.id])
            redirect(action: "list")
            return
        }

        [doacaoInstance: doacaoInstance]
    }

    def edit() {
        def doacaoInstance = Doacao.get(params.id)
        if (!doacaoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'doacao.label', default: 'Doacao'), params.id])
            redirect(action: "list")
            return
        }

        [doacaoInstance: doacaoInstance]
    }

    def update() {
        def doacaoInstance = Doacao.get(params.id)
        if (!doacaoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'doacao.label', default: 'Doacao'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (doacaoInstance.version > version) {
                doacaoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'doacao.label', default: 'Doacao')] as Object[],
                        "Another user has updated this Doacao while you were editing")
                render(view: "edit", model: [doacaoInstance: doacaoInstance])
                return
            }
        }

        doacaoInstance.properties = params

        if (!doacaoInstance.save(flush: true)) {
            render(view: "edit", model: [doacaoInstance: doacaoInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'doacao.label', default: 'Doacao'), doacaoInstance.id])
        redirect(action: "show", id: doacaoInstance.id)
    }

    def delete() {
        def doacaoInstance = Doacao.get(params.id)
        if (!doacaoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'doacao.label', default: 'Doacao'), params.id])
            redirect(action: "list")
            return
        }

        try {
            doacaoInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'doacao.label', default: 'Doacao'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'doacao.label', default: 'Doacao'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
