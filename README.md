Endpoints

1) "/questions/addquestion"
   method name: POST
   purpose: To add single question in database
   data format to be sent: QuestionType=
   {
        "qtitle": "What is Java?",
        "qcategory": "Java",
        "option1": "A snake",
        "option2": "A coffee",
        "option3": "A programming language",
        "option4": "None",
        "qanswer": "A programming language",
        "difficulty": "Easy"
    }

   2) "questions/getallquestions"
      method type: GET
      purpose:TO get all questions from database
      data format that API will send to client side(List<QuestionType>)=
      [
        {
        "id": 1,
        "qtitle": "What is Java?",
        "qcategory": "Java",
        "option1": "A snake",
        "option2": "A coffee",
        "option3": "A programming language",
        "option4": "None",
        "qanswer": "A programming language",
        "difficulty": "Easy"
        },
    {
        "id": 2,
        "qtitle": "Which annotation is used for dependency injection in Spring?",
        "qcategory": "Java",
        "option1": "@AutoInject",
        "option2": "@Autowired",
        "option3": "@Resource",
        "option4": "@Injectable",
        "qanswer": "@Autowired",
        "difficulty": "Medium"
   }
   ]
  
  3) "/filter/{category}/{difficulty}/{no}"
     Method type: GET
     purpose:To get list of exam questions based on filters
     data format that API will send to client (List<ExamQ>)=
     [
    {
        "id": 1,
        "qtitle": "What is Java?",
        "option1": "A snake",
        "option2": "A coffee",
        "option3": "A programming language",
        "option4": "None",
        "diff": "Easy"
    },
    {
        "id": 7,
        "qtitle": "What is the default value of a boolean variable in Java?",
        "option1": "true",
        "option2": "false",
        "option3": "null",
        "option4": "0",
        "diff": "Easy"
    }
]
