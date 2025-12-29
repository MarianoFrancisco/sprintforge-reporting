package com.sprintforge.reporting.reporting.infrastructure.adapter.out.rest.identity.mapper;

import com.sprintforge.common.application.port.result.*;
import com.sprintforge.common.infrastructure.adapter.in.rest.dto.*;

import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class RoleGeneralReportResultMapper {

    public RoleGeneralReportResult toResult(
            RoleGeneralReportResponseDTO response
    ) {
        return new RoleGeneralReportResult(
                mapRoles(response.roles()),
                response.totalRoles(),
                response.activeRoles()
        );
    }

    private static List<RoleBlock> mapRoles(
            List<RoleBlockDTO> roles
    ) {
        return safe(roles).stream()
                .map(RoleGeneralReportResultMapper::mapRoleBlock)
                .toList();
    }

    private static RoleBlock mapRoleBlock(
            RoleBlockDTO role
    ) {
        return new RoleBlock(
                role.roleId(),
                role.roleName(),
                role.roleActive(),

                role.activeUsersCount(),
                role.inactiveUsersCount(),

                mapUsers(role.activeUsers()),
                mapUsers(role.inactiveUsers())
        );
    }

    private static List<RoleUserRow> mapUsers(
            List<RoleUserRowDTO> users
    ) {
        return safe(users).stream()
                .map(u -> new RoleUserRow(
                        u.cui(),
                        u.email()
                ))
                .toList();
    }

    private static <T> List<T> safe(List<T> list) {
        return list == null ? List.of() : list;
    }
}
