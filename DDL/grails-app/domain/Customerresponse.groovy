/**
 * The Customerresponse entity.
 *
 * @author  Scott Beall  FCG
 *
 *
 */
class Customerresponse {
    static mapping = {
         table 'customerresponse'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         // In case a sequence is needed, changed the identity generator for the following code:
//       id generator:'sequence', column:'id', params:[sequence:'customerresponse_sequence']
         id generator:'identity', column:'id'
         id composite:['id'], generator:'assigned'
         customersIdCustomers column:'customers_id'
         questionsIdQuestions column:'questions_id'
    }
    String responseComment
    String customersUserid
    Date dateAnswered
    String response
    Long id

    static constraints = {
        responseComment()
        customersUserid(size: 1..25, blank: false)
        dateAnswered(nullable: true)
        response(size: 0..100)
        id()
        customersIdCustomers()
        questionsIdQuestions()
    }
    String toString() {
        return "${customersId}" 
    }
}
