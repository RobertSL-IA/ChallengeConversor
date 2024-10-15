package Modelos;

public class ConversionTasa {
    private String resultado; 
    private String codigo_base; 
    private Tasas conversion_rates;

 
    public String getResultado() { 
        return resultado;
    }

    public void setResultado(String resultado) { 
        this.resultado = resultado;
    }

    public String getCodigo_base() { 
        return codigo_base;
    }

    public void setCodigo_base(String codigo_base) { 
        this.codigo_base = codigo_base;
    }

    public Tasas getTasas_conversion() { 
        return conversion_rates;
    }

    public void setTasas_conversion(Tasas conversion_rates) { 
        this.conversion_rates = conversion_rates;
    }
}

