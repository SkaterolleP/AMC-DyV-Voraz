set key top left vertical inside
set xlabel "coordenada x"
set ylabel "coordenada y"
plot "datos.dat" t "CONJUNTO"
replot "sol.dat" w lp
