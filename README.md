# exercise
Coding Exercise :
•	Create a Spring boot application as a REST service with following endpoint
GET /coding/exercise/quiz
•	Use the following 2 services as downstream services (data source) for fetching response and simplifying to a single response for above endpoint
https://opentdb.com/api.php?amount=5&category=11
https://opentdb.com/api.php?amount=5&category=12
•	Create POJO for the response from data sources and transform the response format of JSON to following expected format to respond back for REST endpoint (Attached)

Response : 

{
  "quiz": [
    {
      "category": "Entertainment: Film",
      "results": [
        {
          "type": "multiple",
          "difficulty": "medium",
          "question": "Which 1958 movie starred Kirk Douglas and Tony Curtis as half-brothers Einar and Eric?",
          "all_answers": [
            "The Vikings",
            "The Long Ships",
            "Prince Valiant",
            "Spartacus"
          ],
          "correct_answer": "The Vikings"
        },
        {
            "type": "multiple",
            "difficulty": "medium",
            "question": "In which 1955 film does Frank Sinatra play Nathan Detroit?",
            "all_answers": [
                "Guys and Dolls",
                "Anchors Aweigh",
                "From Here to Eternity",
                "High Society"
            ],
            "correct_answer": "Guys and Dolls"
        }
      ]
    },
    {
      "category": "Entertainment: Music",
      "results": [
        {
          "type": "multiple",
          "difficulty": "medium",
          "question": "Which of these artists do NOT originate from France?",
          "all_answers": [
            "The Chemical Brothers",
            "Air",
            "Justice",
            "Daft Punk"
          ],
          "correct_answer": "The Chemical Brothers"
        },
        {
            "type": "multiple",
            "difficulty": "hard",
            "question": "Who won the 1989 Drum Corps International championships?",
            "all_answers": [
                "Blue Devils",
                "The Academy",
                "Santa Clara Vanguard",
                "The Bluecoats"
            ],
            "correct_answer": "Santa Clara Vanguard"
        }
      ]
    }
  ]
}
