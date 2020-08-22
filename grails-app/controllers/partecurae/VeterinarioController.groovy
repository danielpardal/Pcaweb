package partecurae

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class VeterinarioController {

    VeterinarioService veterinarioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond veterinarioService.list(params), model:[veterinarioCount: veterinarioService.count()]
    }

    def show(Long id) {
        respond veterinarioService.get(id)
    }

    def create() {
        respond new Veterinario(params)
    }

    def save(Veterinario veterinario) {
        if (veterinario == null) {
            notFound()
            return
        }

        try {
            veterinarioService.save(veterinario)
        } catch (ValidationException e) {
            respond veterinario.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'veterinario.label', default: 'Veterinario'), veterinario.id])
                redirect veterinario
            }
            '*' { respond veterinario, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond veterinarioService.get(id)
    }

    def update(Veterinario veterinario) {
        if (veterinario == null) {
            notFound()
            return
        }

        try {
            veterinarioService.save(veterinario)
        } catch (ValidationException e) {
            respond veterinario.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'veterinario.label', default: 'Veterinario'), veterinario.id])
                redirect veterinario
            }
            '*'{ respond veterinario, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        veterinarioService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'veterinario.label', default: 'Veterinario'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'veterinario.label', default: 'Veterinario'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
