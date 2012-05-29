package sgd



import org.junit.*
import grails.test.mixin.*

@TestFor(IgrejaController)
@Mock(Igreja)
class IgrejaControllerTests {


    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/igreja/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.igrejaInstanceList.size() == 0
        assert model.igrejaInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.igrejaInstance != null
    }

    void testSave() {
        controller.save()

        assert model.igrejaInstance != null
        assert view == '/igreja/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/igreja/show/1'
        assert controller.flash.message != null
        assert Igreja.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/igreja/list'


        populateValidParams(params)
        def igreja = new Igreja(params)

        assert igreja.save() != null

        params.id = igreja.id

        def model = controller.show()

        assert model.igrejaInstance == igreja
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/igreja/list'


        populateValidParams(params)
        def igreja = new Igreja(params)

        assert igreja.save() != null

        params.id = igreja.id

        def model = controller.edit()

        assert model.igrejaInstance == igreja
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/igreja/list'

        response.reset()


        populateValidParams(params)
        def igreja = new Igreja(params)

        assert igreja.save() != null

        // test invalid parameters in update
        params.id = igreja.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/igreja/edit"
        assert model.igrejaInstance != null

        igreja.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/igreja/show/$igreja.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        igreja.clearErrors()

        populateValidParams(params)
        params.id = igreja.id
        params.version = -1
        controller.update()

        assert view == "/igreja/edit"
        assert model.igrejaInstance != null
        assert model.igrejaInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/igreja/list'

        response.reset()

        populateValidParams(params)
        def igreja = new Igreja(params)

        assert igreja.save() != null
        assert Igreja.count() == 1

        params.id = igreja.id

        controller.delete()

        assert Igreja.count() == 0
        assert Igreja.get(igreja.id) == null
        assert response.redirectedUrl == '/igreja/list'
    }
}
