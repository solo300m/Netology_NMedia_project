package ru.netology.nmedia.dto

data class Post (
    val id:Long,
    val author:String,
    val content:String,
    val published:String,
    var likes:Int,
    var shared:Int,
    var view:Int,
    var likedByMe: Boolean = false
)
{
    companion object{
        public fun intToString(param:Int):String{
            if(param < 1000)
                return param.toString();
            if(param in 1000..9999){
                val double: Long = (Math.round((param / 100).toDouble()))
                val first = double/10;
                val second = double % 10;
                return "${first.toString()},${second.toString()}K";
            }
            if(param in 10000..999999){
                val double: Long = (Math.round((param / 100).toDouble()))
                val first = double/10;
                return "${first.toString()}K";
            }
            if(param >= 1000000){
                val double: Long = (Math.round((param / 100000).toDouble()))
                val first = double/10;
                val second = double % 10;
                return "${first.toString()},${second.toString()}M";
            }
            return "string from Int"
        }
    }

}
