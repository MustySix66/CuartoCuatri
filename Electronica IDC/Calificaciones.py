def Promedio():
    sum=0
    Nombre = str(input("Escribe tu nombre: "))
    for i in range (3):
        calif= float(input("Dame una calificación: "))
        sum+=calif
    prom = round(sum/3, 2)
    print("El promedio de ",Nombre," es: ",prom)

Promedio()