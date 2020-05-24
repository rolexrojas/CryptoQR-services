package com.mono40.types;

/**
 * @author Birendra Kumar
 * @date
 */
public class GenerateReqResponse {

    int   outIdSolicitud;
    double   outSuma;
    double  outTasa;
    double  outPrima;
    String outdescresultadoOutField;
    String outcodresultadoOutField;
    public GenerateReqResponse() {


    }

    /**
     *
     * @param outIdSolicitud
     * @param outSuma
     * @param outTasa
     * @param outPrima
     * @param outdescresultadoOutField
     * @param outcodresultadoOutField
     */
    public GenerateReqResponse(int outIdSolicitud, double outSuma, double outTasa,
                               double outPrima, String outdescresultadoOutField,
                               String outcodresultadoOutField) {
        super();
        this.outIdSolicitud = outIdSolicitud;
        outSuma = outSuma;
        this.outTasa = outTasa;
        this.outPrima = outPrima;
        this.outdescresultadoOutField = outdescresultadoOutField;
        this.outcodresultadoOutField = outcodresultadoOutField;
    }

    /**
     * @author Birendra Kumar
     * @return int type value
     */
    public int getOutIdSolicitud() {
        return outIdSolicitud;
    }

    /**
     * @author Birendra Kumar
     * @param outIdSolicitud
     */
    public void setOutIdSolicitud(int outIdSolicitud) {
        this.outIdSolicitud = outIdSolicitud;
    }

    /**
     * @author Birendra Kumar
     * @return int type value
     */
    public double getOutSuma() {
        return outSuma;
    }

    /**
     * @author Birendra Kumar
     * @param outSuma
     */
    public void setOutSuma(double outSuma) {
        this.outSuma = outSuma;
    }

    /**
     * @author Birendra Kumar
     * @return double type value
     */
    public double getOutTasa() {
        return outTasa;
    }

    /**
     * @author Birendra Kumar
     * @param outTasa
     */
    public void setOutTasa(double outTasa) {
        this.outTasa = outTasa;
    }

    /**
     * @author Birendra Kumar
     * @return double type value
     */
    public double getOutPrima() {
        return outPrima;
    }

    /**
     * @author Birendra Kumar
     * @param outPrima
     */
    public void setOutPrima(double outPrima) {
        this.outPrima = outPrima;
    }

    /**
     * @author Birendra Kumar
     * @return String type value
     */
    public String getOutdescresultadoOutField() {
        return outdescresultadoOutField;
    }

    /**
     * @author Birendra Kumar
     * @param outdescresultadoOutField
     */
    public void setOutdescresultadoOutField(String outdescresultadoOutField) {
        this.outdescresultadoOutField = outdescresultadoOutField;
    }

    /**
     * @author Birendra Kumar
     * @return String type value
     */
    public String getOutcodresultadoOutField() {
        return outcodresultadoOutField;
    }

    /**
     * @author Birendra Kumar
     * @param outcodresultadoOutField
     */
    public void setOutcodresultadoOutField(String outcodresultadoOutField) {
        this.outcodresultadoOutField = outcodresultadoOutField;
    }

    /**
     * String type value
     * @return
     */
    @Override
    public String toString() {
        return "IssueReqReponse [outIdSolicitud=" + outIdSolicitud
                + ", StringoutSuma=" + outSuma + ", outTasa=" + outTasa
                + ", outPrima=" + outPrima + ", outdescresultadoOutField="
                + outdescresultadoOutField + ", outcodresultadoOutField="
                + outcodresultadoOutField + "]";
    }


}
