/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;
import Entidades.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
/**
 *
 * @author MARCO RENÉ ESQUIVEL JUÁREZ
 */
public class frmHospital extends javax.swing.JFrame {

    private ArrayList<Areas> lAreas;
    private ArrayList<Relaciones> lRel;
    DefaultTableModel mdlTabla;
    DefaultTableModel mdlTablaC1;
    DefaultTableModel mdlTablaC2;
    DefaultTableModel mdlTablaC3;
    DefaultTableModel mdlTablaC4;
    int nCons;
    public frmHospital() {
        initComponents();
        this.mdlTabla= (DefaultTableModel) this.jTable1.getModel();
        this.mdlTablaC1= (DefaultTableModel) this.tblC1.getModel();
        this.mdlTablaC2= (DefaultTableModel) this.tblC2.getModel();
        this.mdlTablaC3= (DefaultTableModel) this.tblC3.getModel();
        this.mdlTablaC4= (DefaultTableModel) this.tblC4.getModel();
        this.lAreas=new ArrayList<>();
        this.lRel=new ArrayList<>();
        simularDatos();
        cargarAreas();
        limpiarControles();
        nCons = 1;
        this.lblNCons.setText(Integer.toString(nCons));
        validar();
    }
    
    private void simularDatos()
    {
       //inicializar las sucursales
        //sucursal 1
        this.lAreas.add(new Areas("Cirujia", 
                              new Persona("Juan", "Perez", "1234"),
                              new ArrayList<>()));
        this.lAreas.get(0).getlMed().add(new Persona("Miguel", "Benavides", "Medico1"));
        this.lAreas.get(0).getlMed().add(new Persona("Samuel", "Paniagua", "Medico2"));
        this.lAreas.get(0).getlMed().add(new Persona("Ivan", "Sandoval", "Medico3"));
        
        //sucursal 2
        this.lAreas.add(new Areas("General",
                         new Persona("José", "Rodríguez", "1234"),
                         new ArrayList<>()));
        this.lAreas.get(1).getlMed().add(new Persona("Carolina", "Solito", "Medico4"));
        this.lAreas.get(1).getlMed().add(new Persona("Bryan", "Solis", "Medico5"));
        this.lAreas.get(1).getlMed().add(new Persona("José", "Cabrera", "Medico6"));
        
        //sucursal 3

        this.lAreas.add(new Areas("Pediatria",
                         new Persona("Amelia", "Rivas", "1234"),
                         new ArrayList<>())); 
        this.lAreas.get(2).getlMed().add(new Persona("Amanda", "Castro", "Medico7"));
        this.lAreas.get(2).getlMed().add(new Persona("Arnold", "Arita", "Medico8"));
        this.lAreas.get(2).getlMed().add(new Persona("Bertha", "Rodríguez", "Medico9"));
    }  
    
    private void cargarAreas()
    {
       this.cmbArea.removeAllItems();
       for(int i=0; i<this.lAreas.size(); i++)
       {
           this.cmbArea.addItem(this.lAreas.get(i).getNombre());
       } 
       this.cmbArea.setSelectedIndex(-1);
    } 
    
    private void cargaTabla()
    {     
        this.mdlTabla.setRowCount(0);
        for(int j=0; j<this.lRel.size(); j++)
        {
            String[] registro = { 
                this.lRel.get(j).getoClien().getNombre()+ " " + this.lRel.get(j).getoClien().getApellido(),
                this.lRel.get(j).getoClien().getDUI(),
                Integer.toString(this.lRel.get(j).getoCons().getDias()),
                Double.toString(this.lRel.get(j).getoCons().getMonto()),
                this.lRel.get(j).getoArea().getNombre(),
                this.lRel.get(j).getoMed().getNombre()+ " " +this.lRel.get(j).getoMed().getApellido()
            };
            this.mdlTabla.addRow(registro);
        }
    }
    private void cargarC1(){
        this.mdlTablaC1.setRowCount(0);
        for(int j=0; j<this.lRel.size(); j++)
        {
            if(this.lRel.get(j).getoCons().getMonto()<= this.cuart1()) {
                String[] registro = { 
                    this.lRel.get(j).getoClien().getNombre()+ " " + this.lRel.get(j).getoClien().getApellido(),
                    this.lRel.get(j).getoClien().getDUI(),
                    Integer.toString(this.lRel.get(j).getoCons().getDias()),
                    Double.toString(this.lRel.get(j).getoCons().getMonto()),
                    this.lRel.get(j).getoArea().getNombre(),
                    this.lRel.get(j).getoMed().getNombre()+ " " +this.lRel.get(j).getoMed().getApellido()
                };
                this.mdlTablaC1.addRow(registro);
            }
        }
    }
    private void cargarC2(){
        this.mdlTablaC2.setRowCount(0);
        for(int j=0; j<this.lRel.size(); j++)
        {
            if(this.lRel.get(j).getoCons().getMonto()<= this.cuart2() && this.lRel.get(j).getoCons().getMonto()>this.cuart1()) {
                String[] registro = { 
                    this.lRel.get(j).getoClien().getNombre()+ " " + this.lRel.get(j).getoClien().getApellido(),
                    this.lRel.get(j).getoClien().getDUI(),
                    Integer.toString(this.lRel.get(j).getoCons().getDias()),
                    Double.toString(this.lRel.get(j).getoCons().getMonto()),
                    this.lRel.get(j).getoArea().getNombre(),
                    this.lRel.get(j).getoMed().getNombre()+ " " +this.lRel.get(j).getoMed().getApellido()
                };
                this.mdlTablaC2.addRow(registro);
            }
        }
    }
    private void cargarC3(){
        this.mdlTablaC3.setRowCount(0);
        for(int j=0; j<this.lRel.size(); j++)
        {
            if(this.lRel.get(j).getoCons().getMonto()<= this.cuart3() && this.lRel.get(j).getoCons().getMonto()>this.cuart2()) {
                String[] registro = { 
                    this.lRel.get(j).getoClien().getNombre()+ " " + this.lRel.get(j).getoClien().getApellido(),
                    this.lRel.get(j).getoClien().getDUI(),
                    Integer.toString(this.lRel.get(j).getoCons().getDias()),
                    Double.toString(this.lRel.get(j).getoCons().getMonto()),
                    this.lRel.get(j).getoArea().getNombre(),
                    this.lRel.get(j).getoMed().getNombre()+ " " +this.lRel.get(j).getoMed().getApellido()
                };
                this.mdlTablaC3.addRow(registro);
            }
        }
    }
    private void cargarC4(){
        this.mdlTablaC4.setRowCount(0);
        for(int j=0; j<this.lRel.size(); j++)
        {
            if(this.lRel.get(j).getoCons().getMonto()<= this.maximo() && this.lRel.get(j).getoCons().getMonto()>this.cuart3()) {
                String[] registro = { 
                    this.lRel.get(j).getoClien().getNombre()+ " " + this.lRel.get(j).getoClien().getApellido(),
                    this.lRel.get(j).getoClien().getDUI(),
                    Integer.toString(this.lRel.get(j).getoCons().getDias()),
                    Double.toString(this.lRel.get(j).getoCons().getMonto()),
                    this.lRel.get(j).getoArea().getNombre(),
                    this.lRel.get(j).getoMed().getNombre()+ " " +this.lRel.get(j).getoMed().getApellido()
                };
                this.mdlTablaC4.addRow(registro);
            }
        }
    }
    
    private void cargarMedicos(int pIdSuc)
    {
       this.cmbDoc.removeAllItems();
       for(int i=0; i<this.lAreas.get(pIdSuc).getlMed().size(); i++)
       {
           this.cmbDoc.addItem(this.lAreas.get(pIdSuc).getlMed().get(i).getNombre()+" "+
                                   this.lAreas.get(pIdSuc).getlMed().get(i).getApellido());
       }
    } 
    private int dias(){
        return Integer.parseInt(this.jSpinner1.getValue().toString());
    }
    private double calc(){
        double tot= 25.00;
        if (this.jCheckBox1.isSelected()) {
            tot += 4.50 * dias();
        }
        if (this.jCheckBox2.isSelected()) {
            tot += 7.25 * dias();
        }
        if (this.jCheckBox3.isSelected()) {
            tot += 1.77 * dias();
        }
        return tot;
    }
    
    private void validar(){
        if (this.jSlider1.getValue() == 1) {
            this.jSpinner1.setEnabled(false);
            this.jCheckBox1.setEnabled(false);
            this.jCheckBox2.setEnabled(false);
            this.jCheckBox3.setEnabled(false);
            this.jSpinner1.setValue(1);
            this.jCheckBox1.setSelected(false);
            this.jCheckBox2.setSelected(false);
            this.jCheckBox3.setSelected(false);
        }else{
            this.jSpinner1.setEnabled(true);
            this.jCheckBox1.setEnabled(true);
            this.jCheckBox2.setEnabled(true);
            this.jCheckBox3.setEnabled(true);
        }
    }
    private double minimo()
    {
       double min=0;
       if(this.lRel.size()>0)
       {
           min=this.lRel.get(0).getoCons().getMonto();
           for(int i=1; i<this.lRel.size(); i++)
           {
               if(min>this.lRel.get(i).getoCons().getMonto())
                   min=this.lRel.get(i).getoCons().getMonto();
           }
       }
       return min;
    }
    
    private double maximo()
    {
        
       double max=0;
       if(this.lRel.size()>0)
       {
           max=this.lRel.get(0).getoCons().getMonto();
           for(int i=1; i<this.lRel.size(); i++)
           {
               if(max<this.lRel.get(i).getoCons().getMonto())
                   max=this.lRel.get(i).getoCons().getMonto();
           }
       }
       return max;
    }
    
    private double promedio()
    {
        double prom=(this.sumatoria()/this.lRel.size());
        prom*=100;
        prom= Math.round(prom);
        return (prom/100);
    }
    
    private double sumatoria()
    {
        double total=0;
        for(int i=0; i<this.lRel.size(); i++)
        {
            total+= this.lRel.get(i).getoCons().getMonto();
        }
        total*=100;
        total= Math.round(total);
        return (total/100);
    }
    static boolean validarDUI(String DUI){
        return DUI.matches("^[0-9]{8}"+"-"+"[0-9]{1}$");
    }
    
    private double cuart1(){
       double lim= maximo();
       lim*=0.25;
       lim*=100;
       lim = Math.round(lim);
       return (lim/100);
    }
    private double cuart2(){
       double lim= maximo();
       lim*=0.50;
       lim*=100;
       lim = Math.round(lim);
       return (lim/100);
    }
    private double cuart3(){
       double lim= maximo();
       lim*=0.75;
       lim*=100;
       lim = Math.round(lim);
       return (lim/100);
    }
    private void limpiarControles(){
        this.jSlider1.setValue(1);
        this.cmbArea.setSelectedIndex(-1);
        this.txtNombrePa.setText("");
        this.txtApellidoPa.setText("");
        this.txtDUIPa.setText("");
        this.txtBusDoc.setText("");
        this.txtBusPac.setText("");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSlider1 = new javax.swing.JSlider();
        jLabel7 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblNCons = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cmbArea = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cmbDoc = new javax.swing.JComboBox<>();
        btnPagar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombrePa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellidoPa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDUIPa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtMax = new javax.swing.JTextField();
        txtMin = new javax.swing.JTextField();
        txtTot = new javax.swing.JTextField();
        txtProm = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtBusDoc = new javax.swing.JTextField();
        btnBusDoc = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        txtBusPac = new javax.swing.JTextField();
        btnBusPac = new javax.swing.JButton();
        btnTodos = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblC2 = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblC1 = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblC3 = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblC4 = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jSlider1.setMaximum(1);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jLabel7.setText("Dias");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Consulta N°");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Si");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("No");

        lblNCons.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNCons.setText("----");

        jCheckBox1.setText("Comida");

        jCheckBox3.setText("Television");

        jCheckBox2.setText("Medicina");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Ingresado");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Area Medica");

        cmbArea.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbAreaItemStateChanged(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Doctor");

        btnPagar.setText("PAGAR");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        jLabel8.setText("Precio base de consulta $25.00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNCons))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox2))
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox3))
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinner1))
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnPagar)
                                .addGap(41, 41, 41))
                            .addComponent(cmbDoc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel11)
                        .addComponent(cmbArea, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblNCons))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10)
                        .addComponent(jLabel6))
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmbArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel12)
                .addGap(1, 1, 1)
                .addComponent(cmbDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPagar)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Paciente");

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido");

        jLabel4.setText("DUI");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombrePa)
                    .addComponent(txtApellidoPa)
                    .addComponent(txtDUIPa, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombrePa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtApellidoPa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDUIPa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Paciente", "DUI", "Dias", "Total a pagar", "Area", "Doctor"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Estadisticas");

        jLabel14.setText("Maximo");

        jLabel15.setText("Minimo");

        jLabel16.setText("Promedio");

        jLabel17.setText("Total");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel15)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMax, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                            .addComponent(txtMin))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTot)
                            .addComponent(txtProm, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)))
                    .addComponent(jLabel13))
                .addContainerGap(136, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16)
                    .addComponent(txtMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17)
                    .addComponent(txtMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel18.setText("Doc.");

        btnBusDoc.setText("Buscar Doctor");
        btnBusDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusDocActionPerformed(evt);
            }
        });

        jLabel19.setText("DUI ");

        btnBusPac.setText("Buscar Paciente");
        btnBusPac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusPacActionPerformed(evt);
            }
        });

        btnTodos.setText("Mostrar Todos");
        btnTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(254, 233, 120));
        jPanel4.setPreferredSize(new java.awt.Dimension(484, 163));

        tblC2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Paciente", "DUI", "Dias", "Total a pagar", "Area", "Doctor"
            }
        ));
        jScrollPane3.setViewportView(tblC2);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Cuartil 2: 25%-50%");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(242, 123, 97));

        tblC1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Paciente", "DUI", "Dias", "Total a pagar", "Area", "Doctor"
            }
        ));
        jScrollPane2.setViewportView(tblC1);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Cuartil 1: 0%-25%");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(129, 250, 138));
        jPanel6.setPreferredSize(new java.awt.Dimension(484, 163));

        tblC3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Paciente", "DUI", "Dias", "Total a pagar", "Area", "Doctor"
            }
        ));
        jScrollPane4.setViewportView(tblC3);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Cuartil 3: 50%-75%");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(203, 152, 250));
        jPanel7.setPreferredSize(new java.awt.Dimension(484, 163));

        tblC4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Paciente", "DUI", "Dias", "Total a pagar", "Area", "Doctor"
            }
        ));
        jScrollPane5.setViewportView(tblC4);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Cuartil 4: 75%-100%");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel23)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBusPac)
                            .addComponent(btnBusDoc)
                            .addComponent(btnTodos)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtBusPac, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtBusDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtBusDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBusDoc)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtBusPac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBusPac)
                        .addGap(18, 18, 18)
                        .addComponent(btnTodos))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbAreaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbAreaItemStateChanged
        if (this.cmbArea.getSelectedIndex() == -1) {
            this.cmbDoc.setSelectedIndex(-1);
        }else{
            this.cargarMedicos(this.cmbArea.getSelectedIndex());
        }
    }//GEN-LAST:event_cmbAreaItemStateChanged

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed

        if (validarDUI(this.txtDUIPa.getText()) && !"".equals(this.txtNombrePa.getText()) && !"".equals(this.txtApellidoPa.getText()) && this.cmbArea.getSelectedIndex()!= -1 && this.cmbDoc.getSelectedIndex()!= -1) {
           this.lRel.add(new Relaciones(
            new Persona(this.txtNombrePa.getText().trim().toUpperCase(), 
                        this.txtApellidoPa.getText().trim().toUpperCase(),
                        this.txtDUIPa.getText().trim()), 
            this.lAreas.get(this.cmbArea.getSelectedIndex()), 
            this.lAreas.get(this.cmbArea.getSelectedIndex()).getlMed().get(this.cmbDoc.getSelectedIndex()),
            new Consulta(this.lblNCons.getText().trim(), 
                        this.dias(),
                        this.calc()
            )));
        nCons++;
        this.lblNCons.setText(Integer.toString(nCons));
        this.cargaTabla();
        validar();
        this.txtMin.setText(Double.toString(this.minimo()));
        this.txtMax.setText(Double.toString(this.maximo()));
        this.txtProm.setText(Double.toString(this.promedio()));
        this.txtTot.setText(Double.toString(this.sumatoria())); 
        this.cargarC1();
        this.cargarC2();
        this.cargarC3();
        this.cargarC4();
        limpiarControles();
        }else{JOptionPane.showMessageDialog(null, "Ingrese datos validos");}      
    }//GEN-LAST:event_btnPagarActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        validar();
    }//GEN-LAST:event_jSlider1StateChanged

    private void btnBusDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusDocActionPerformed
        if (!"".equals(this.txtBusDoc.getText())) {
            this.mdlTabla.setRowCount(0);
            String docBus= this.txtBusDoc.getText();
         
            for (int i = 0; i < this.lRel.size(); i++) {
                if ((this.lRel.get(i).getoMed().getNombre()+ " " +this.lRel.get(i).getoMed().getApellido()).equals(docBus)) {
                    String[] registro = { 
                    this.lRel.get(i).getoClien().getNombre()+ " " + this.lRel.get(i).getoClien().getApellido(),
                    this.lRel.get(i).getoClien().getDUI(),
                    Integer.toString(this.lRel.get(i).getoCons().getDias()),
                    Double.toString(this.lRel.get(i).getoCons().getMonto()),
                    this.lRel.get(i).getoArea().getNombre(),
                    this.lRel.get(i).getoMed().getNombre()+ " " +this.lRel.get(i).getoMed().getApellido()
                    };
                    this.mdlTabla.addRow(registro); 
                }
            }
            limpiarControles(); 
        }else{
            JOptionPane.showMessageDialog(null, "Ingrese el nombre del doctor que desea busaca");
        }
        
    }//GEN-LAST:event_btnBusDocActionPerformed

    private void btnBusPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusPacActionPerformed
        
        if (validarDUI(this.txtBusPac.getText())) {
            this.mdlTabla.setRowCount(0);
            String DUIBus= this.txtBusPac.getText();
         
            for (int i = 0; i < this.lRel.size(); i++) {
                if (this.lRel.get(i).getoClien().getDUI().equals(DUIBus)) {
                    String[] registro = { 
                    this.lRel.get(i).getoClien().getNombre()+ " " + this.lRel.get(i).getoClien().getApellido(),
                    this.lRel.get(i).getoClien().getDUI(),
                    Integer.toString(this.lRel.get(i).getoCons().getDias()),
                    Double.toString(this.lRel.get(i).getoCons().getMonto()),
                    this.lRel.get(i).getoArea().getNombre(),
                    this.lRel.get(i).getoMed().getNombre()+ " " +this.lRel.get(i).getoMed().getApellido()
                    };
                this.mdlTabla.addRow(registro); 
                }
            }
            limpiarControles();
        }else{
            JOptionPane.showMessageDialog(null, "Introduzca el DUI del paciente que desea buscar");
        }
        
    }//GEN-LAST:event_btnBusPacActionPerformed

    private void btnTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosActionPerformed
        cargaTabla();
    }//GEN-LAST:event_btnTodosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmHospital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmHospital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmHospital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmHospital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmHospital().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusDoc;
    private javax.swing.JButton btnBusPac;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnTodos;
    private javax.swing.JComboBox<String> cmbArea;
    private javax.swing.JComboBox<String> cmbDoc;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblNCons;
    private javax.swing.JTable tblC1;
    private javax.swing.JTable tblC2;
    private javax.swing.JTable tblC3;
    private javax.swing.JTable tblC4;
    private javax.swing.JTextField txtApellidoPa;
    private javax.swing.JTextField txtBusDoc;
    private javax.swing.JTextField txtBusPac;
    private javax.swing.JTextField txtDUIPa;
    private javax.swing.JTextField txtMax;
    private javax.swing.JTextField txtMin;
    private javax.swing.JTextField txtNombrePa;
    private javax.swing.JTextField txtProm;
    private javax.swing.JTextField txtTot;
    // End of variables declaration//GEN-END:variables
}
