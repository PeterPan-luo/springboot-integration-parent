package com.luo.mmseckkill.validation;

import com.google.common.base.Strings;
import com.luo.mmseckkill.util.ValidatorUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsMobileValidator implements ConstraintValidator<IsMobile, String> {

   private boolean required = false;
   public void initialize(IsMobile constraint) {

      this.required = constraint.required();

   }

   public boolean isValid(String value, ConstraintValidatorContext context) {
      if (required){
         return ValidatorUtil.isMobile(value);
      }else {
         if (Strings.isNullOrEmpty(value)){
            return true;
         }else{
            return ValidatorUtil.isMobile(value);
         }
      }
   }
}
