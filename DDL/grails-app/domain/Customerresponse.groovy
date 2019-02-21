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
//       id generator:'sequence', column:'customers_id', params:[sequence:'customerresponse_sequence']
         id generator:'identity', column:'customers_id'
         // In case a sequence is needed, changed the identity generator for the following code:
//       id generator:'sequence', column:'questions_id', params:[sequence:'customerresponse_sequence']
         id generator:'identity', column:'questions_id'
         id composite:['customersId','questionsId'], generator:'assigned'
    }
    Long customersId
    Long questionsId
    String responseComment
    String customersUserid
    Date dateAnswered
    String response

    static constraints = {
        customersId(max: 9999999999L)
        questionsId(max: 9999999999L)
        responseComment()
        customersUserid(size: 1..25, blank: false)
        dateAnswered(nullable: true)
        response(size: 0..100)
    }
    String toString() {
        return "${customersId}" 
    }
}
