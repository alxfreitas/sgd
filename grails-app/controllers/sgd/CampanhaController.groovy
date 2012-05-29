package sgd

import org.springframework.dao.DataIntegrityViolationException

class CampanhaController extends BaseController {
//class CampanhaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [campanhaInstanceList: Campanha.list(params), campanhaInstanceTotal: Campanha.count()]
    }

    def create() {
        [campanhaInstance: new Campanha(params)]
    }

    def save() {
        def campanhaInstance = new Campanha(params)
        campanhaInstance.saldo = 0.0
        campanhaInstance.situacao = 0.0
        campanhaInstance.ativa = true
        if (!campanhaInstance.save(flush: true)) {
            render(view: "create", model: [campanhaInstance: campanhaInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'campanha.label', default: 'Campanha'), campanhaInstance.id])
        redirect(action: "show", id: campanhaInstance.id)
    }

    def show() {
        def campanhaInstance = Campanha.get(params.id)
        if (!campanhaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'campanha.label', default: 'Campanha'), params.id])
            redirect(action: "list")
            return
        }

        [campanhaInstance: campanhaInstance]
    }

    def edit() {
        def campanhaInstance = Campanha.get(params.id)
        if (!campanhaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'campanha.label', default: 'Campanha'), params.id])
            redirect(action: "list")
            return
        }

        [campanhaInstance: campanhaInstance]
    }

    def update() {
        def campanhaInstance = Campanha.get(params.id)
        if (!campanhaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'campanha.label', default: 'Campanha'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (campanhaInstance.version > version) {
                campanhaInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'campanha.label', default: 'Campanha')] as Object[],
                        "Another user has updated this Campanha while you were editing")
                render(view: "edit", model: [campanhaInstance: campanhaInstance])
                return
            }
        }

        campanhaInstance.properties = params

        if (!campanhaInstance.save(flush: true)) {
            render(view: "edit", model: [campanhaInstance: campanhaInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'campanha.label', default: 'Campanha'), campanhaInstance.id])
        redirect(action: "show", id: campanhaInstance.id)
    }

    def delete() {
        def campanhaInstance = Campanha.get(params.id)
        if (!campanhaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'campanha.label', default: 'Campanha'), params.id])
            redirect(action: "list")
            return
        }

        try {
            campanhaInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'campanha.label', default: 'Campanha'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'campanha.label', default: 'Campanha'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
