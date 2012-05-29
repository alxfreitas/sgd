package sgd

import org.springframework.dao.DataIntegrityViolationException

class SemeadorController extends BaseController {
//class SemeadorController {

    def authService
    def semeadorService

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [semeadorInstanceList: Semeador.list(params), semeadorInstanceTotal: Semeador.count()]
    }

     def listByCodigo() {
        def list = semeadorService.listByCodigo(params.codigo)
        [semeadorInstanceList: list, semeadorInstanceTotal: list.size()]
    }

    def create() {
        [semeadorInstance: new Semeador(params)]
    }

    def save() {
        def semeadorInstance = new Semeador(params)
        semeadorInstance.ativo = true
        semeadorInstance.dataCadastro = new Date()
        semeadorInstance.dataUltimaAlteracao = new Date()
        semeadorInstance.codigo =  semeadorService.getCodigoSemeador(semeadorInstance)

        if (!semeadorInstance.save(flush: true)) {
            render(view: "create", model: [semeadorInstance: semeadorInstance])
            return
        }
        semeadorInstance.usuario = authService.criarUsuario(semeadorInstance)
        flash.message = message(code: 'default.created.message', args: [message(code: 'semeador.label', default: 'Semeador'), semeadorInstance.id])
        redirect(action: "show", id: semeadorInstance.id)
    }

    def show() {
        def semeadorInstance = Semeador.get(params.id)
        if (!semeadorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'semeador.label', default: 'Semeador'), params.id])
            redirect(action: "list")
            return
        }

        [semeadorInstance: semeadorInstance]
    }

    def edit() {
        def semeadorInstance = Semeador.get(params.id)
        if (!semeadorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'semeador.label', default: 'Semeador'), params.id])
            redirect(action: "list")
            return
        }

        [semeadorInstance: semeadorInstance]
    }

    def update() {
        def semeadorInstance = Semeador.get(params.id)
        semeadorInstance.dataUltimaAlteracao = new Date()
        if (!semeadorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'semeador.label', default: 'Semeador'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (semeadorInstance.version > version) {
                semeadorInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'semeador.label', default: 'Semeador')] as Object[],
                        "Another user has updated this Semeador while you were editing")
                render(view: "edit", model: [semeadorInstance: semeadorInstance])
                return
            }
        }

        semeadorInstance.properties = params

        if (!semeadorInstance.save(flush: true)) {
            render(view: "edit", model: [semeadorInstance: semeadorInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'semeador.label', default: 'Semeador'), semeadorInstance.id])
        redirect(action: "show", id: semeadorInstance.id)
    }

    def delete() {
        def semeadorInstance = Semeador.get(params.id)
        if (!semeadorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'semeador.label', default: 'Semeador'), params.id])
            redirect(action: "list")
            return
        }

        try {
            semeadorInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'semeador.label', default: 'Semeador'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'semeador.label', default: 'Semeador'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
