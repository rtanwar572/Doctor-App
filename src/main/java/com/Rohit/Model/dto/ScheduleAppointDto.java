package com.Rohit.Model.dto;

import com.Rohit.Model.Appointment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleAppointDto {
    AuthenticationInputDto inputDto;
    Appointment appointment;
}
