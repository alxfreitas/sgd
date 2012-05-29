class UrlMappings {

	static mappings = {


		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/home"(view:"/base/home")

        "/"(controller:'usuario', action:'login')

		"500"(view:'/error')
	}
}
