package partecurae

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class TipoExameController {

    TipoExameService tipoExameService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond tipoExameService.list(params), model:[tipoExameCount: tipoExameService.count()]
    }

    def show(Long id) {
        respond tipoExameService.get(id)
    }

    def create() {
        respond new TipoExame(params)
    }

    def save(TipoExame tipoExame) {
        if (tipoExame == null) {
            notFound()
            return
        }

        try {
            tipoExameService.save(tipoExame)
        } catch (ValidationException e) {
            respond tipoExame.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tipoExame.label', default: 'TipoExame'), tipoExame.id])
                redirect tipoExame
            }
            '*' { respond tipoExame, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond tipoExameService.get(id)
    }

    def update(TipoExame tipoExame) {
        if (tipoExame == null) {
            notFound()
            return
        }

        try {
            tipoExameService.save(tipoExame)
        } catch (ValidationException e) {
            respond tipoExame.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'tipoExame.label', default: 'TipoExame'), tipoExame.id])
                redirect tipoExame
            }
            '*'{ respond tipoExame, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        tipoExameService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'tipoExame.label', default: 'TipoExame'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoExame.label', default: 'TipoExame'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
