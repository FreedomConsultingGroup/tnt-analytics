/**
 * The Comments entity.
 *
 * @author  Scott Beall  FCG
 *
 *
 */
class Comments {
    static mapping = {
         table 'comments'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         // In case a sequence is needed, changed the identity generator for the following code:
//       id generator:'sequence', column:'id', params:[sequence:'comments_sequence']
         id generator:'identity', column:'id'
         customersIdCustomers column:'customers_id'
    }
    Long id
    String comments
    Date dateAdded
    // Relation
    Customers customersIdCustomers

    static constraints = {
        id(max: 9999999999L)
        comments(blank: false)
        dateAdded(nullable: true)
        customersIdCustomers()
    }
    String toString() {
        return "${id}" 
    }
}
