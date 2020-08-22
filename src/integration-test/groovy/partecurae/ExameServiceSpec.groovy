package partecurae

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ExameServiceSpec extends Specification {

    ExameService exameService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Exame(...).save(flush: true, failOnError: true)
        //new Exame(...).save(flush: true, failOnError: true)
        //Exame exame = new Exame(...).save(flush: true, failOnError: true)
        //new Exame(...).save(flush: true, failOnError: true)
        //new Exame(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //exame.id
    }

    void "test get"() {
        setupData()

        expect:
        exameService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Exame> exameList = exameService.list(max: 2, offset: 2)

        then:
        exameList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        exameService.count() == 5
    }

    void "test delete"() {
        Long exameId = setupData()

        expect:
        exameService.count() == 5

        when:
        exameService.delete(exameId)
        sessionFactory.currentSession.flush()

        then:
        exameService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Exame exame = new Exame()
        exameService.save(exame)

        then:
        exame.id != null
    }
}
