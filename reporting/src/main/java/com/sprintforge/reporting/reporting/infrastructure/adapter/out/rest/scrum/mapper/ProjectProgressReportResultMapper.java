package com.sprintforge.reporting.reporting.infrastructure.adapter.out.rest.scrum.mapper;

import com.sprintforge.common.application.port.result.EmployeeResult;
import com.sprintforge.common.application.port.result.ProjectProgressItem;
import com.sprintforge.common.application.port.result.ProjectProgressReportResult;
import com.sprintforge.common.application.port.result.SprintCurrent;
import com.sprintforge.common.infrastructure.adapter.in.rest.dto.EmployeeDTO;
import com.sprintforge.common.infrastructure.adapter.in.rest.dto.ProjectProgressItemDTO;
import com.sprintforge.common.infrastructure.adapter.in.rest.dto.ProjectProgressReportResponseDTO;
import com.sprintforge.common.infrastructure.adapter.in.rest.dto.SprintCurrentDTO;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class ProjectProgressReportResultMapper {
    public ProjectProgressReportResult toResult(
            ProjectProgressReportResponseDTO response
    ) {
        return new ProjectProgressReportResult(
                response.totalProjects(),
                response.totalSprints(),
                response.startedSprints(),
                response.createdSprints(),
                response.completedSprints(),
                mapProjects(response.projects())
        );
    }

    private static List<ProjectProgressItem> mapProjects(
            List<ProjectProgressItemDTO> projects
    ) {
        return projects.stream()
                .map(ProjectProgressReportResultMapper::mapProject)
                .toList();
    }

    private static ProjectProgressItem mapProject(
            ProjectProgressItemDTO project
    ) {
        return new ProjectProgressItem(
                project.projectId(),
                project.projectKey(),
                project.projectName(),

                project.backlogCount(),
                project.pendingCount(),
                project.inProgressCount(),
                project.completedCount(),
                project.totalStories(),

                project.progressPercentage(),

                project.totalSprints(),
                project.startedSprints(),
                project.createdSprints(),
                project.completedSprints(),

                mapSprints(project.currentSprints()),
                mapEmployees(project.members())
        );
    }

    private static List<SprintCurrent> mapSprints(
            List<SprintCurrentDTO> sprints
    ) {
        return sprints.stream()
                .map(sprint -> new SprintCurrent(
                        sprint.sprintId(),
                        sprint.name(),
                        sprint.goal(),
                        sprint.status(),
                        sprint.startDate(),
                        sprint.endDate()
                ))
                .toList();
    }

    private static List<EmployeeResult> mapEmployees(
            List<EmployeeDTO> members
    ) {
        return members.stream()
                .map(member -> new EmployeeResult(
                        member.id(),
                        member.email(),
                        member.fullName(),
                        member.profileImage(),
                        member.position()
                ))
                .toList();
    }
}
