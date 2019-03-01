/**
 * The Auditlog entity.
 *
 * @author  Scott Beall  FCG
 *
 *
 */
class Auditlog {
    static mapping = {
         table 'auditlog'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         // In case a sequence is needed, changed the identity generator for the following code:
//       id generator:'sequence', column:'id', params:[sequence:'auditlog_sequence']
         id generator:'identity', column:'id'
         customersIdCustomers column:'customers_id'
         customersIdAuditevents column:'customers_id'
    }
    Long auditeventsId
    Date timeOfEvent
    String customersUserid
    Long id
    // Relation
    Customers customersIdCustomers
    // Relation
    Auditevents customersIdAuditevents

    static hasMany = [ idAuditeventsList : Auditevents ]

    static constraints = {
        auditeventsId(max: 9999999999L)
        timeOfEvent()
        customersUserid(size: 1..25, blank: false)
        id()
        customersIdCustomers()
        customersIdAuditevents()
        // Bidirectional oneToMany
        idAuditeventsList()
    }
    String toString() {
        return "${id}" 
    }
}
