import cv2
import os
import numpy as np

# Path donde se encuentran las imagenes de entrenamiento
dataPath = '/home/arturo/Documents/ReconocimientoFacial/faces/train'
#pasamos el path a la variable que guarda los directorios
peopleList = os.listdir(dataPath)
#print('Lista de personas: ', peopleList)
#el primer array es para guardar los labels/nombres, en este caso se le asignaran numero de 0 a X a la persona en cada folder
#el segundo array guarda la informacion de la iamgen 
# el "label" es un valor que incrementa para ir nombrando los labels
labels = []
facesData = []
label = 0

#primer for para ir recorriendo la lista de las de las carpetas de las personas
for nameDir in peopleList:
	# accede a la carpeta con las imagenes de la persona
	personPath = dataPath + '/' + nameDir
	print('Leyendo las imágenes')
	# segundo for para las imagenes dentro de la carpeta de la persona
	for fileName in os.listdir(personPath):
		# imprime el nombre del archivo
		print('Rostros: ', nameDir + '/' + fileName)
		# agrega al array de lables el numero en el que se ecuentre label
		labels.append(label)
		# agrega al array de FacesData la imagen en escala de grises, eso es lo que hace el 0 del final
		facesData.append(cv2.imread(personPath+'/'+fileName,0))
		#image = cv2.imread(personPath+'/'+fileName,0)
		#cv2.imshow('image',image)
		#cv2.waitKey(10)
		
	#aumneta el label para pasar a la siguiente persona
	label = label + 1

# Métodos para entrenar el reconocedor
recognizer = cv2.face.LBPHFaceRecognizer_create()
# Entrenando el reconocedor de rostros
print("Entrenando...")
recognizer.train(facesData, np.array(labels))

# Almacenando el modelo obtenido
recognizer.write('modeloLBPHFace.xml')
print("Modelo almacenado...")