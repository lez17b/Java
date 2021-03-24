//package com.company;

public class Fraction
{
    private int numerator = 0;		// numerator (and keeps sign)
    private int denominator = 1;		// always stores positive value

    public Fraction()
    {

    }

    public Fraction(int n)
    {
        this(n,1);
    }

    public Fraction(int n, int d)
    {
        if (!set(n, d))
            set(0,1);
    }

    public boolean set(int n, int d)
    {
        if (d > 0)
        {
            numerator = n;
            denominator = d;
            return true;
        }
        else
            return false;
    }

    public void show()
    {
        System.out.print(numerator + "/" + denominator);
    }

    public String toString()
    {
        return (numerator + "/" + denominator);
    }

    public int getNumerator()
    {
        return numerator;
    }

    public int getDenominator()
    {
        return denominator;
    }

    public double decimal()
    {
        return (double)numerator / denominator;
    }

    //*********************************************************************
    //*** name: simplify                                                ***
    //*** description:  Converts a fraction to its simplest version.    ***
    //*** Author: Luciano Zavala                                        ***
    //*********************************************************************

    public Fraction simplify()
    {
        int num = this.getNumerator();
        int dem = this.getDenominator();

        if(num == 0)
        {
            dem = 1;
        }
        else
        {
            for(int i = dem; i > 0; i--)
            {
                if(num% i == 0 && dem % i == 0)
                {
                    num = num / i;
                    dem = dem / i;
                }
            }
        }
        if (dem < 0)
        {
            dem = dem * -1;
            num = num * -1;
        }
        return new Fraction(num, dem);

    }

    //*********************************************************************
    //*** name: add                                                     ***
    //*** description:  CAdds two fractions adn returns the simplified  ***
    //***   version.                                                    ***
    //*** Author: Luciano Zavala                                        ***
    //*********************************************************************


    public Fraction add(Fraction f) {
        int num1 = this.getNumerator();
        int dem1 = this.getDenominator();
        int num2 = f.getNumerator();
        int dem2 = f.getDenominator();
        int num = 0, dem = 0;

        num = ((num1 * dem1) + (num2 * dem2));
        dem = (dem1 * dem2);

        if(dem < 0)
        {
            dem = dem * -1;
            num = num * -1;
        }

        Fraction fr = new Fraction(num, dem);
        return fr.simplify();
    }

    //************************************************************************
    //*** name: subtract                                                   ***
    //*** description: subtracts two fractions adn returns the simplified  ***
    //***   version.                                                       ***
    //*** Author: Luciano Zavala                                           ***
    //************************************************************************

    public Fraction subtract(Fraction f)
    {
        int num1 = this.getNumerator();
        int dem1 = this.getDenominator();
        int num2 = f.getNumerator();
        int dem2 = f.getDenominator();
        int num = 0, dem = 0;

        num = ((num1 * dem1) - (num2 * dem2));
        dem = dem1 * dem2;

        if(dem < 0)
        {
            dem = dem * -1;
            num = num * -1;
        }

        Fraction fr = new Fraction(num, dem);
        return fr.simplify();
    }

    //************************************************************************
    //*** name: multiply                                                   ***
    //*** description: multiplies two fractions adn returns the simplified ***
    //***   version.                                                       ***
    //*** Author: Luciano Zavala                                           ***
    //************************************************************************

    public Fraction multiply(Fraction f)
    {
        int num1 = this.getNumerator();
        int dem1 = this.getDenominator();
        int num2 = f.getNumerator();
        int dem2 = f.getDenominator();
        int num = 0, dem = 0;

        num = num1 * num2;
        dem = dem1 * dem2;

        if(dem < 0)
        {
            dem = dem * -1;
            num = num * -1;
        }

        Fraction fr = new Fraction(num, dem);
        return fr.simplify();


    }

    //************************************************************************
    //*** name: divide                                                     ***
    //*** description: divide two fractions adn returns the simplified     ***
    //***   version.                                                       ***
    //*** Author: Luciano Zavala                                           ***
    //************************************************************************

    public Fraction divide(Fraction f)
    {
        int num1 = this.getNumerator();
        int dem1 = this.getDenominator();
        int num2 = f.getNumerator();
        int dem2 = f.getDenominator();
        int num = 0, dem = 0;

        num = num1 * dem2;
        dem = dem1 * num2;

        if(dem < 0)
        {
            dem = dem * -1;
            num = num * -1;
        }

        Fraction fr = new Fraction(num, dem);
        return fr.simplify();
    }
    // more features? -- think some up and add them!
}
