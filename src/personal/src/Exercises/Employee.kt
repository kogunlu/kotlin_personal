package personal.src.Exercises


abstract class XtelCompany {
    abstract val departmentName: String
}


abstract class Employee : XtelCompany() {
    abstract val firstName: String
    abstract val lastName: String
    abstract val salary: Int


}

open class EmployeeCreate
    (
    final override val departmentName: String,
    final override val firstName: String,
    final override val lastName: String,
    final override val salary: Int
) : Employee() {

    val fullName = "${this.firstName} ${this.lastName}"
    val department = this.departmentName
    val employeeSalary = this.salary

    open fun writeStatus() {
        println("-----Calisan detaylari-----")
        println("Ad-soyad: $fullName\nCalistigi birim: $department\nAylik net ucreti: $employeeSalary USD\n--------")
    }


}


fun main() {


    val kuday = EmployeeCreate("HR", "Kuday", "Ogunlu", 1_000)
    val eylem = EmployeeCreate("Accounting", "Eylem", "Ogunlu", 750)
    val berker = EmployeeCreate("Management", "Berker", "Demirkiran", 2_500)

    kuday.writeStatus()
    eylem.writeStatus()
    berker.writeStatus()

}