package partecurae

import grails.gorm.transactions.Transactional

class BootStrap {

    def init = { servletContext ->
        addTestUser()
    }

    @Transactional
    void addTestUser() {
        def adminRole = new Role(authority: 'ROLE_ADMIN').save()

        def testUser = new User(username: 'admin', password: 'admin').save()

        UserRole.create testUser, adminRole

        UserRole.withSession {
            it.flush()
            it.clear()
        }

        assert User.count() == 1
        assert Role.count() == 1
        assert UserRole.count() == 1
    }

    def destroy = {
    }
}
