/**
 * The Questions entity.
 *
 * @author  Scott Beall  FCG
 *
 *
 */
class Questions {
    static mapping = {
         table 'questions'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         // In case a sequence is needed, changed the identity generator for the following code:
//       id generator:'sequence', column:'id', params:[sequence:'questions_sequence']
         id generator:'identity', column:'id'
    }
    Long id
    String question
    String questionDescription
    Date dateCreated
    Date dateModified
    java.math.BigDecimal questionTypeId

    static constraints = {
        id(max: 9999999999L)
        question(size: 1..2000, blank: false)
        questionDescription(size: 1..2000, blank: false)
        dateCreated()
        dateModified()
        questionTypeId()
    }
    String toString() {
        return "${id}" 
    }
}
