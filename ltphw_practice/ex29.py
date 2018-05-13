from sys import argv

script, people, dogs, cats = argv

print("This is the %r script" %(script))
print("So you're saying there are %r people, %r dogs and %r cats in this world.." %(people, dogs, cats))

if people > cats:
	print ("The world is a better place with less cats than people")

if people < cats:
	print ("More cats than people? The world is doomed!")

if people == cats:
	print ("Not really sure if I should live in such a world")

if cats >= dogs:
	print ("Huh, there are more cats than dogs too. This is bad!")

if cats <= dogs:
	print ("More dogs than cats. Better!")
