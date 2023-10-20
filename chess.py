tahta = [['' for i in range(8)] for i in range(8)]
şah = []
for r in range(8):
    line = input('input the line: ')
    for c in range(len(line)):
        tahta[r][c] = line[c]
        şah.append(r)
        şah.append(c)

        
