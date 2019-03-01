/**
 * The Auditevents entity.
 *
 * @author  Scott Beall  FCG
 *
 *
 */
class Auditevents {
    static mapping = {
         table 'auditevents'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         idAuditlog column:'id'
    }
    String description
    String code
    Date eventDate
    // Relation
    Auditlog idAuditlog

    static constraints = {
        description(size: 1..2000, blank: false)
        code(size: 1..50, blank: false)
        eventDate(nullable: true)
        idAuditlog()
    }
    String toString() {
        return "${id}" 
    }
}
