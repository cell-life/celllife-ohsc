{
    "CqmUssdSubmissionRequest": {
        "ussdSession": {
            "id": "${ussdSessionId}",
            "string": "*130*555*1000#",
            "startDateTime": "${startDateTime}",
            "endDateTime": "${endDateTime}"
        },
        "user": {
            "msisdn": "${msisdn}",
            "mnoCode": "${mno}"
        },
        "questionnaire": {
            "version": "1.0"
        },
        "submission": {
            "clinicCode": "${clinicCode}",
            "languageCode": "${languageCode}",
            "questions": [
                {
                    "domainCode": "1",
                    "text": "How clean were the toilets",
                    "answer": {
                        "text": "Very clean",
                        "rating": "${domainRating1}"
                    }
                },
                {
                    "domainCode": "2",
                    "text": "How helpful were the staff",
                    "answer": {
                        "text": "Very unhelpful",
                        "rating": "${domainRating2}"
                    }
                },
                {
                    "domainCode": "3",
                    "text": "How long did you wait?",
                    "answer": {
                        "text": "4-6 hours",
                        "rating": "${domainRating3}"
                    }
                },
                {
                    "domainCode": "4",
                    "text": "Was there security?",
                    "answer": {
                        "text": "A little.",
                        "rating": "${domainRating4}"
                    }
                },
                {
                    "domainCode": "5",
                    "text": "Was the hospital clean.",
                    "answer": {
                        "text": "It was acceptably clean.",
                        "rating": "${domainRating5}"
                    }
                },
                {
                    "domainCode": "6",
                    "text": "Did you get the medicine you needed?",
                    "answer": {
                        "text": "Some of it.",
                        "rating": "${domainRating6}"
                    }
                }
            ]
        }
    }
}