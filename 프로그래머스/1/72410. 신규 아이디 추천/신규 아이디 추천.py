def solution(new_id):
    answer = ''
    
    #1
    new_id = new_id.lower()
    #2
    rules = "abcdefghijklmnopqrstuvwxyz0123456789-_."
    for ch in new_id:
        if ch in rules:
            answer += ch
    #3
    while ".." in answer:
        answer = answer.replace("..", ".")
    #4
    answer = answer.strip(".")
    #5
    if answer == "":
        answer = "a" 
    #6
    if len(answer) >= 16:
        answer = answer[:15].rstrip(".")
        # if answer[-1] == ".":
        #     answer = answer[:14]
    #7
    while len(answer) < 3:
        answer += answer[-1]
        
    return answer