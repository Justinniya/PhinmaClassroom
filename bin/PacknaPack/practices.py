import time
class human:
    def __init__ (self, name, username, password):
        self.name = name
        self.username = username
        self.password = password

    def show(self):
        print(f'Name : {self.name}\nUsername : {self.username}\nPassword : {self.password}')


while(True):
    name = input("Enter YOur name : ")
    time.sleep(2)
    username = input("Enter your username : ")
    time.sleep(2)
    password = input("Enter your password : ")
    time.sleep(2)
    print("[proccessing account please wait ......]")
    time.sleep(3)
    print("Create account success....")
    justin = human(name,username,password)
    choose = int(input("Choose\n1. Show profile\n2. Exit\nEnter : "))
    if(choose == 1):
        justin.show()
    elif(choose == 2):
        print('Thanks for using!')
        break
    else:
        print('invalid choices')
