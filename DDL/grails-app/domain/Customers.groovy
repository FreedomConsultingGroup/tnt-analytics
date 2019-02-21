/**
 * The Customers entity.
 *
 * @author  Scott Beall  FCG
 *
 *
 */
class Customers {
    static mapping = {
         table 'customers'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         // In case a sequence is needed, changed the identity generator for the following code:
//       id generator:'sequence', column:'id', params:[sequence:'customers_sequence']
         id generator:'identity', column:'id'
    }
    Long id
    String userid
    String lastName
    String firstName
    Date lastLogin
    Date dateCreated
    Date dateModified

    static constraints = {
        id(max: 9999999999L)
        userid(size: 1..25, blank: false)
        lastName(size: 1..100, blank: false)
        firstName(size: 1..100, blank: false)
        lastLogin()
        dateCreated(nullable: true)
        dateModified(nullable: true)
    }
    String toString() {
        return "${id}" 
    }
}
