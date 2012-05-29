package sgd

import org.springframework.dao.DataIntegrityViolationException

class IgrejaController extends BaseController {
//class IgrejaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [igrejaInstanceList: Igreja.list(params), igrejaInstanceTotal: Igreja.count()]
    }

    def create() {
        [igrejaInstance: new Igreja(params)]
    }

    def save() {
        def igrejaInstance = new Igreja(params)
        if (!igrejaInstance.save(flush: true)) {
            render(view: "create", model: [igrejaInstance: igrejaInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'igreja.label', default: 'Igreja'), igrejaInstance.id])
        redirect(action: "show", id: igrejaInstance.id)
    }

    def show() {
        def igrejaInstance = Igreja.get(params.id)
        if (!igrejaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'igreja.label', default: 'Igreja'), params.id])
            redirect(action: "list")
            return
        }

        [igrejaInstance: igrejaInstance]
    }

    def edit() {
        def igrejaInstance = Igreja.get(params.id)
        if (!igrejaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'igreja.label', default: 'Igreja'), params.id])
            redirect(action: "list")
            return
        }

        [igrejaInstance: igrejaInstance]
    }

    def update() {
        def igrejaInstance = Igreja.get(params.id)
        if (!igrejaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'igreja.label', default: 'Igreja'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (igrejaInstance.version > version) {
                igrejaInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'igreja.label', default: 'Igreja')] as Object[],
                        "Another user has updated this Igreja while you were editing")
                render(view: "edit", model: [igrejaInstance: igrejaInstance])
                return
            }
        }

        igrejaInstance.properties = params

        if (!igrejaInstance.save(flush: true)) {
            render(view: "edit", model: [igrejaInstance: igrejaInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'igreja.label', default: 'Igreja'), igrejaInstance.id])
        redirect(action: "show", id: igrejaInstance.id)
    }

    def delete() {
        def igrejaInstance = Igreja.get(params.id)
        if (!igrejaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'igreja.label', default: 'Igreja'), params.id])
            redirect(action: "list")
            return
        }

        try {
            igrejaInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'igreja.label', default: 'Igreja'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'igreja.label', default: 'Igreja'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
