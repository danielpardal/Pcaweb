package partecurae

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TipoExameServiceSpec extends Specification {

    TipoExameService tipoExameService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new TipoExame(...).save(flush: true, failOnError: true)
        //new TipoExame(...).save(flush: true, failOnError: true)
        //TipoExame tipoExame = new TipoExame(...).save(flush: true, failOnError: true)
        //new TipoExame(...).save(flush: true, failOnError: true)
        //new TipoExame(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //tipoExame.id
    }

    void "test get"() {
        setupData()

        expect:
        tipoExameService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<TipoExame> tipoExameList = tipoExameService.list(max: 2, offset: 2)

        then:
        tipoExameList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        tipoExameService.count() == 5
    }

    void "test delete"() {
        Long tipoExameId = setupData()

        expect:
        tipoExameService.count() == 5

        when:
        tipoExameService.delete(tipoExameId)
        sessionFactory.currentSession.flush()

        then:
        tipoExameService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        TipoExame tipoExame = new TipoExame()
        tipoExameService.save(tipoExame)

        then:
        tipoExame.id != null
    }
}
