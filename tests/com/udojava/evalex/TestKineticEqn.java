package com.udojava.evalex;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by raj on 6/12/14.
 */
public class TestKineticEqn {

    @Test
     public void testKineticEqnEvaluation(){
        //String eqn = "[2][{[1/[0.040200000000000014]exp(-2t)] + [1/[-0.040200000000000014]exp(-2.0402t)]}]+0.5*([1][{[1/[1]exp(-2t)]}])";
        //String eqn = "2(1/0.040200000000000014exp(-2t) + 1/-0.040200000000000014exp(-2.0402t))+0.5*(1(1/1exp(-2t)))";
        //String eqn = "[4.0804][(1/[4.0804] - {[1/[2*0.040200000000000014]exp(-2t)] + [1/[2.0402*-0.040200000000000014]exp(-2.0402t)]}]+0.5*([2][(1/[2] - {[1/[2*1]exp(-2t)]}])";
        //String eqn = "4.0804(1/4.0804 - (1/2*0.040200000000000014exp(-2t) + 1/2.0402*-0.040200000000000014exp(-2.0402t))+0.5*(2(1/2 - (1/2*1exp(-2t)))";

        //String eqn = "2*-0.2";

        eqn = eqn.replaceAll("\\[","(").replaceAll("\\]", ")").replaceAll("\\{","(").replaceAll("\\}",")");
        System.out.println(eqn);

        final Expression expression = new Expression(eqn);
        expression.addFunction(expression.new Function("exp", 1) {
            @Override
            public BigDecimal eval(List<BigDecimal> parameters) {
                return new Expression("2.718 ^ " + parameters.get(0).toString()).eval();
            }
        });


        expression.setVariable("t","1.1");

        System.out.print(expression.eval());


    }

}
