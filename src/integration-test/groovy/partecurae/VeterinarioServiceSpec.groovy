package partecurae

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VeterinarioServiceSpec extends Specification {

    VeterinarioService veterinarioService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Veterinario(...).save(flush: true, failOnError: true)
        //new Veterinario(...).save(flush: true, failOnError: true)
        //Veterinario veterinario = new Veterinario(...).save(flush: true, failOnError: true)
        //new Veterinario(...).save(flush: true, failOnError: true)
        //new Veterinario(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //veterinario.id
    }

    void "test get"() {
        setupData()

        expect:
        veterinarioService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Veterinario> veterinarioList = veterinarioService.list(max: 2, offset: 2)

        then:
        veterinarioList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        veterinarioService.count() == 5
    }

    void "test delete"() {
        Long veterinarioId = setupData()

        expect:
        veterinarioService.count() == 5

        when:
        veterinarioService.delete(veterinarioId)
        sessionFactory.currentSession.flush()

        then:
        veterinarioService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Veterinario veterinario = new Veterinario()
        veterinarioService.save(veterinario)

        then:
        veterinario.id != null
    }
}
