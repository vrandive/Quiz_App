package com.example.quiz_app

object Constants {

    const val User_Name: String = "user_name"
    const val Total_questions: String = "total_questions"
    const val Correct_Answers: String = "correct_answers"

    fun getQuestions():ArrayList<Question>{

        val question_list = ArrayList<Question>()

        //1
        val que1 = Question(
            1,"What country does this flag belong to?", R.drawable.ic_flag_of_argentina,
            "Argentina","Australia","India", "Armenia",1
        )
        question_list.add(que1)

        //2
        val que2 = Question(
            1,"What country does this flag belong to?", R.drawable.ic_flag_of_australia,
            "Argentina","Australia","India", "Armenia",2
        )
        question_list.add(que2)

        //3
        val que3 = Question(
            1,"What country does this flag belong to?", R.drawable.ic_flag_of_belgium,
            "Argentina","Australia","Belgium", "Armenia",3
        )
        question_list.add(que3)

        //4
        val que4 = Question(
            1,"What country does this flag belong to?", R.drawable.ic_flag_of_brazil,
            "Argentina","Australia","India", "Brazil",4
        )
        question_list.add(que4)

        //5
        val que5 = Question(
            1,"What country does this flag belong to?", R.drawable.ic_flag_of_denmark,
            "Denmark","Australia","India", "Armenia",1
        )
        question_list.add(que5)

        //6
        val que6 = Question(
            1,"What country does this flag belong to?", R.drawable.ic_flag_of_fiji,
            "Argentina","Fiji","India", "Armenia",2
        )
        question_list.add(que6)

        //7
        val que7 = Question(
            1,"What country does this flag belong to?", R.drawable.ic_flag_of_germany,
            "Argentina","Australia","Germany", "Armenia",3
        )
        question_list.add(que7)

        //8
        val que8 = Question(
            1,"What country does this flag belong to?", R.drawable.ic_flag_of_india,
            "Argentina","Australia","India", "Armenia",3
        )
        question_list.add(que8)

        //9
        val que9 = Question(
            1,"What country does this flag belong to?", R.drawable.ic_flag_of_kuwait,
            "Argentina","Australia","India", "Kuwait",4
        )
        question_list.add(que9)

        return question_list
    }

}