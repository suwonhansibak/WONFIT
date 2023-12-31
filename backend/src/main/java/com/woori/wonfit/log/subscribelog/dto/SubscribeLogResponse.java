package com.woori.wonfit.log.subscribelog.dto;

import com.woori.wonfit.log.subscribelog.domain.SubscribeLog;
import com.woori.wonfit.member.member.domain.Member;
import com.woori.wonfit.product.deposit.domain.Deposit;
import com.woori.wonfit.product.fund.domain.Fund;
import com.woori.wonfit.product.loan.domain.Loan;
import com.woori.wonfit.product.savings.domain.Savings;
import lombok.*;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SubscribeLogResponse {
    private Long id;
    private Member member;
    private String subDate;
    private String expirePeriod;
    private int subDeposit;
    private int subSavings;
    private int monthlyCharge;
    private String monthlyChargeDate;
    private String taxDeduction;
    private int fundQuantity;
    private int loanAmount;
    private String repaymentMethod;
    private boolean subscribeStatus;
    private Deposit deposit;
    private Savings savings;
    private Fund fund;
    private Loan loan;

    public static SubscribeLogResponse From_sub_log(SubscribeLog subscribeLog, String time) {
        return SubscribeLogResponse.builder()
                .id(subscribeLog.getId())
                .member(subscribeLog.getMember())
                .subDate(time)
                .expirePeriod(subscribeLog.getExpirePeriod())
                .subDeposit(subscribeLog.getSubDeposit())
                .subSavings(subscribeLog.getSubSavings())
                .monthlyCharge(subscribeLog.getMonthlyCharge())
                .monthlyChargeDate(subscribeLog.getMonthlyChargeDate())
                .taxDeduction(subscribeLog.getTaxDeduction())
                .fundQuantity(subscribeLog.getFundQuantity())
                .loanAmount(subscribeLog.getLoanAmount())
                .repaymentMethod(subscribeLog.getRepaymentMethod())
                .subscribeStatus(subscribeLog.isSubscribeStatus())
                .deposit(subscribeLog.getDeposit())
                .savings(subscribeLog.getSavings())
                .fund(subscribeLog.getFund())
                .loan(subscribeLog.getLoan())
                .build();
    }
}
