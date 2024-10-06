def ordenar(num1, num2, num3):
    numeros = [num1, num2, num3]
    listaOrdenada = sorted(numeros)
    print("Los números ordenados de menor a mayor son: ",listaOrdenada)

def ordenar2(num1, num2, num3):
    if (num1 < num2):
        if (num1 < num3):
            ps1 = num1
            if (num2 < num3):
                ps2 = num2
                ps3 = num3
            else:
                ps2 = num3
                ps3 = num2
        else:
            ps1 = num3
            ps2 = num1
            ps3 = num2
    else:
        if (num2 < num3):
            ps1 = num2
            if (num1 < num3):
                ps2 = num1
                ps3 = num3
            else:
                ps2 = num3
                ps3 = num1
        else:
            ps1 = num3
            ps2 = num2
            ps3 = num1
    print("El orden de los números es: ", ps1, ps2, ps3)

num1 = float(input("Dame el primer número: "))    
num2 = float(input("Dame el segundo número: "))
num3 = float(input("Dame el tercer número: "))
ordenar(num1, num2, num3)
ordenar2(num1, num2, num3)