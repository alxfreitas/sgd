package sgd

import org.springframework.dao.DataIntegrityViolationException

class PerfilController extends BaseController {
//class PerfilController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [perfilInstanceList: Perfil.list(params), perfilInstanceTotal: Perfil.count()]
    }

    def create() {
        [perfilInstance: new Perfil(params)]
    }

    def save() {
        def perfilInstance = new Perfil(params)
        if (!perfilInstance.save(flush: true)) {
            render(view: "create", model: [perfilInstance: perfilInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'perfil.label', default: 'Perfil'), perfilInstance.id])
        redirect(action: "show", id: perfilInstance.id)
    }

    def show() {
        def perfilInstance = Perfil.get(params.id)
        if (!perfilInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'perfil.label', default: 'Perfil'), params.id])
            redirect(action: "list")
            return
        }

        [perfilInstance: perfilInstance]
    }

    def edit() {
        def perfilInstance = Perfil.get(params.id)
        if (!perfilInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'perfil.label', default: 'Perfil'), params.id])
            redirect(action: "list")
            return
        }

        [perfilInstance: perfilInstance]
    }

    def update() {
        def perfilInstance = Perfil.get(params.id)
        if (!perfilInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'perfil.label', default: 'Perfil'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (perfilInstance.version > version) {
                perfilInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'perfil.label', default: 'Perfil')] as Object[],
                        "Another user has updated this Perfil while you were editing")
                render(view: "edit", model: [perfilInstance: perfilInstance])
                return
            }
        }

        perfilInstance.properties = params

        if (!perfilInstance.save(flush: true)) {
            render(view: "edit", model: [perfilInstance: perfilInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'perfil.label', default: 'Perfil'), perfilInstance.id])
        redirect(action: "show", id: perfilInstance.id)
    }

    def delete() {
        def perfilInstance = Perfil.get(params.id)
        if (!perfilInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'perfil.label', default: 'Perfil'), params.id])
            redirect(action: "list")
            return
        }

        try {
            perfilInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'perfil.label', default: 'Perfil'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'perfil.label', default: 'Perfil'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
