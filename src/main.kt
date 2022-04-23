import jdk.jfr.Category
import jdk.jfr.DataAmount

fun main () {
  var person1 = CurrentAccount("201034567","Susan",300.0)
    person1.deposit(200.0)
    person1.withdraw(50.0)
    person1.details()
    var person2 = SavingsAccount("2345678","Mercy",4000.0,2)
    person2.withdraw(1000.0)
    person2.withdraw(1000.0)
    person2.withdraw(1000.0)
    println(person2.withdrawals)
    var pro1 = Product("Soap",2.3,100.0,"hygiene")
    var pro2 = Product("Bread",1.3,100.0,"grocery")
    var pro3 = Product("Gun",10.3,100.0,"other")

    categorize(pro1)
    categorize(pro2)
    categorize(pro3)
    println( create("banana"))

}
open class CurrentAccount(var accountnumber:String,var accountname:String,var balance:Double) {
    fun deposit (amount: Double) {
        balance+=amount
        println(balance)
    }
    open fun withdraw(amount: Double) {
        balance-=amount
        println(balance)
    }
    fun details() {
        println("Account number $accountnumber with balance $balance is operated by $accountname")
    }

}
class SavingsAccount (accountnumber: String,accountname: String,balance: Double,var withdrawals:Int):CurrentAccount(accountnumber,accountname,balance) {
    override fun withdraw(amount: Double) {
        if (withdrawals<4) {

            super.withdraw(amount)
            withdrawals++
        }
        else{
            println("You are not eligible to withdraw money")
        }
    }
}
data class Product (var name:String,var weight: Double,var price: Double,var category:String)
 fun categorize(product: Product){
     var grocerylist = mutableListOf<Product>()
     var hygienelist = mutableListOf<Product>()
     var otherlist = mutableListOf<Product>()
     when (product.category) {
         "glocery" -> grocerylist.add(product)
         "hygiene" -> hygienelist.add(product)
         else -> otherlist.add(product)
     }
     println(grocerylist)
     println(hygienelist)
     println(otherlist)
 }
fun create (name: String):String {
    var w = ""
    for (char in name) {
        if (name .indexOf(char)%2 ==0) {
            w+=char
        }
    }
    return w
}
