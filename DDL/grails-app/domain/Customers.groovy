/**
 * The Customers entity.
 *
 * @author    
 *
 *
 */
class Customers {
    static mapping = {
         table 'customers'
         // version is set to false, because this isn't available by default for legacy databases
         version false
    }
    String userid
    String lastName
    String firstName
    Date lastLogin
    Date dateCreated
    Date dateModified

    static hasMany = [ customersIdAuditlogList : Auditlog , customersIdCustomerresponseList : Customerresponse , idDocumentsList : Documents ]

    static constraints = {
        userid(size: 1..25, blank: false)
        lastName(size: 1..100, blank: false)
        firstName(size: 1..100, blank: false)
        lastLogin()
        dateCreated(nullable: true)
        dateModified(nullable: true)
        // Bidirectional oneToMany
        customersIdAuditlogList()
        // Bidirectional oneToMany
        customersIdCustomerresponseList()
        // Bidirectional oneToMany
        idDocumentsList()
    }
    String toString() {
        return "${id}" 
    }
}
