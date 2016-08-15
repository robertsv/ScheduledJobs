package lv.robertsv.speedment.test.webjobs.public_.scheduled_job.impl;

import com.speedment.Speedment;
import com.speedment.internal.core.code.AbstractBaseEntity;
import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;
import javax.annotation.Generated;
import lv.robertsv.speedment.test.webjobs.public_.scheduled_job.ScheduledJob;

/**
 * An implementation representing an entity (for example, a row) in the
 * com.speedment.internal.ui.config.TableProperty@2e10fb13.
 * <p>
 * This Class or Interface has been automatically generated by Speedment. Any
 * changes made to this Class or Interface will be overwritten.
 * 
 * @author Speedment
 */
@Generated("Speedment")
public final class ScheduledJobImpl extends AbstractBaseEntity<ScheduledJob> implements ScheduledJob {
    
    private Long id;
    private String path;
    private String schedule;
    private String status;
    private Integer enabled;
    
    ScheduledJobImpl(Speedment speedment) {
        super(speedment);
    }
    
    public ScheduledJobImpl(Speedment speedment, final ScheduledJob scheduledJob) {
        super(speedment);
        setId(scheduledJob.getId());
        setPath(scheduledJob.getPath());
        setSchedule(scheduledJob.getSchedule());
        setStatus(scheduledJob.getStatus());
        scheduledJob.getEnabled().ifPresent(this::setEnabled);
    }
    
    @Override
    public Long getId() {
        return id;
    }
    
    @Override
    public String getPath() {
        return path;
    }
    
    @Override
    public String getSchedule() {
        return schedule;
    }
    
    @Override
    public String getStatus() {
        return status;
    }
    
    @Override
    public Optional<Integer> getEnabled() {
        return Optional.ofNullable(enabled);
    }
    
    @Override
    public final ScheduledJobImpl setId(Long id) {
        this.id = id;
        return this;
    }
    
    @Override
    public final ScheduledJobImpl setPath(String path) {
        this.path = path;
        return this;
    }
    
    @Override
    public final ScheduledJobImpl setSchedule(String schedule) {
        this.schedule = schedule;
        return this;
    }
    
    @Override
    public final ScheduledJobImpl setStatus(String status) {
        this.status = status;
        return this;
    }
    
    @Override
    public final ScheduledJobImpl setEnabled(Integer enabled) {
        this.enabled = enabled;
        return this;
    }
    
    @Override
    public ScheduledJob copy() {
        return new ScheduledJobImpl(getSpeedment_(), this);
    }
    
    @Override
    public String toString() {
        final StringJoiner sj = new StringJoiner(", ", "{ ", " }");
        sj.add("id = "+Objects.toString(getId()));
        sj.add("path = "+Objects.toString(getPath()));
        sj.add("schedule = "+Objects.toString(getSchedule()));
        sj.add("status = "+Objects.toString(getStatus()));
        sj.add("enabled = "+Objects.toString(getEnabled().orElse(null)));
        return "ScheduledJobImpl "+sj.toString();
    }
    
    @Override
    public boolean equals(Object that) {
        if (this == that) { return true; }
        if (!(that instanceof ScheduledJob)) { return false; }
        @SuppressWarnings("unchecked")
        final ScheduledJob thatScheduledJob = (ScheduledJob)that;
        if (!Objects.equals(this.getId(), thatScheduledJob.getId())) {return false; }
        if (!Objects.equals(this.getPath(), thatScheduledJob.getPath())) {return false; }
        if (!Objects.equals(this.getSchedule(), thatScheduledJob.getSchedule())) {return false; }
        if (!Objects.equals(this.getStatus(), thatScheduledJob.getStatus())) {return false; }
        if (!Objects.equals(this.getEnabled(), thatScheduledJob.getEnabled())) {return false; }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(getId());
        hash = 31 * hash + Objects.hashCode(getPath());
        hash = 31 * hash + Objects.hashCode(getSchedule());
        hash = 31 * hash + Objects.hashCode(getStatus());
        hash = 31 * hash + Objects.hashCode(getEnabled());
        return hash;
    }
    
    @Override
    public Class<ScheduledJob> getEntityClass_() {
        return ScheduledJob.class;
    }
}