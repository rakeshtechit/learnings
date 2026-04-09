import os

def main():
    print("Hello from practice!")
    fileIO()
    removeFile()


def fileIO():
    try:
        f = open("demoFile.txt", "x")
        f.close
    except FileExistsError:
        # The file already exists, so we just skip creation
        f = None 
    finally:
        f.close() # Guaranteed to run

    with open("demoFile.txt", "w") as fl:
        fl.write("This is a test entry")

    with open("demoFile.txt", "a") as fl:
        fl.write("This is append to file")

    with open("demoFile.txt") as fl:
        print(fl.read())
# End FileIO        

def removeFile():

    if os.path.exists("demofile.txt"):
        os.remove("demofile.txt")
    else:
        print("The file does not exist")
# End removeFile


if __name__ == "__main__":
    main()


