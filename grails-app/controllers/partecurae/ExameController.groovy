package partecurae

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class ExameController {

    ExameService exameService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond exameService.list(params), model:[exameCount: exameService.count()]
    }

    def show(Long id) {
        respond exameService.get(id)
    }

    def create() {
        respond new Exame(params)
    }

    def save(Exame exame) {
        if (exame == null) {
            notFound()
            return
        }

        try {
            exameService.save(exame)
        } catch (ValidationException e) {
            respond exame.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'exame.label', default: 'Exame'), exame.id])
                redirect exame
            }
            '*' { respond exame, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond exameService.get(id)
    }

    def update(Exame exame) {
        if (exame == null) {
            notFound()
            return
        }

        try {
            exameService.save(exame)
        } catch (ValidationException e) {
            respond exame.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'exame.label', default: 'Exame'), exame.id])
                redirect exame
            }
            '*'{ respond exame, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        exameService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'exame.label', default: 'Exame'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'exame.label', default: 'Exame'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
