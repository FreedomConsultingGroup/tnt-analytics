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
    }
    String userid
    String lastName
    String firstName
    Date lastLogin
    Date dateCreated
    Date dateModified

    static constraints = {
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
