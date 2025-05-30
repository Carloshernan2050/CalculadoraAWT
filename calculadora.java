import java.awt.*;
import java.awt.event.*;

public class CalculadoraAWT extends Frame implements ActionListener {

    private TextField txtNum1, txtNum2, txtResultado;
    private Choice operaciones;
    private Button btnCalcular;
    private Panel panelResultado;

    public CalculadoraAWT() {
        setTitle("Calculadora AWT");
        setSize(800, 300);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null); 
        setResizable(false);

        
        txtNum1 = new TextField(10);
        txtNum2 = new TextField(10);

        operaciones = new Choice();
        operaciones.add("Suma");
        operaciones.add("Resta");
        operaciones.add("Multiplicación");
        operaciones.add("División");

        btnCalcular = new Button("Calcular");
        btnCalcular.addActionListener(this);

        
        txtResultado = new TextField("Resultado:", 50); 
        txtResultado.setEditable(false);
        txtResultado.setFont(new Font("Arial", Font.BOLD, 12 ));
        txtResultado.setBackground(Color.WHITE);


        panelResultado = new Panel();
        panelResultado.add(txtResultado);

        
        add(new Label("Número 1:"));
        add(txtNum1);

        add(new Label("Número 2:"));
        add(txtNum2);

        add(new Label("Operación:"));
        add(operaciones);

        add(btnCalcular);
        add(panelResultado);

        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str1 = txtNum1.getText().trim();
        String str2 = txtNum2.getText().trim();

        if (str1.isEmpty() || str2.isEmpty()) {
            txtResultado.setText("Resultado: Ingrese ambos números.");
            return;
        }

        try {
            double num1 = Double.parseDouble(str1);
            double num2 = Double.parseDouble(str2);
            String operacion = operaciones.getSelectedItem();
            double resultado = 0;

            switch (operacion) {
                case "Suma":
                    resultado = num1 + num2;
                    break;
                case "Resta":
                    resultado = num1 - num2;
                    break;
                case "Multiplicación":
                    resultado = num1 * num2;
                    break;
                case "División":
                    if (num2 == 0) {
                        txtResultado.setText("Resultado: División por cero no permitida.");
                        return;
                    }
                    resultado = num1 / num2;
                    break;
            }

            txtResultado.setText("Resultado: " + resultado);

        } catch (NumberFormatException ex) {
            txtResultado.setText("Resultado: Ingrese solo números válidos.");
        }
    }

    public static void main(String[] args) {
        new CalculadoraAWT();
    }
}
