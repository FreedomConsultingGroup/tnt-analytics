/**
 * The Auditlog entity.
 *
 * @author    
 *
 *
 */
class Auditlog {
    static mapping = {
         table 'auditlog'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         id column:'auditevents_id'
         // In case a sequence is needed, changed the identity generator for the following code:
//       id generator:'sequence', column:'id', params:[sequence:'auditlog_sequence']
         id generator:'identity', column:'id'
         id composite:['auditeventsId','id'], generator:'assigned'
         customersIdCustomers column:'customers_id'
    }
    Long auditeventsId
    Date timeOfEvent
    String customersUserid
    Long id
    // Relation
    Customers customersIdCustomers

    static hasMany = [ idAuditeventsList : Auditevents ]

    static constraints = {
        auditeventsId(max: 9999999999L)
        timeOfEvent()
        customersUserid(size: 1..25, blank: false)
        id()
        customersIdCustomers()
        // Bidirectional oneToMany
        idAuditeventsList()
    }
    String toString() {
        return "${customersId}" 
    }
}
